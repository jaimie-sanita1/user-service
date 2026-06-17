"""
Routes for the Users API.

Implements the four operations declared in users.yaml:
- GET    /users         List all users
- POST   /users         Create a user
- GET    /users/{id}    Get a user by ID
- DELETE /users/{id}    Delete a user

All routes require a bearer token (matching the `bearerAuth` security scheme).
"""

from fastapi import APIRouter, Depends, HTTPException, Path, Response, status

from ..deps import verify_bearer_token
from ..models import User, UserInput
from ..store import store

router = APIRouter(
    prefix="/users",
    tags=["users"],
    dependencies=[Depends(verify_bearer_token)],
)


@router.get(
    "",
    response_model=list[User],
    summary="List all users",
    status_code=status.HTTP_200_OK,
)
async def list_users() -> list[User]:
    """Return every user in the store."""
    return store.list_users()


@router.post(
    "",
    response_model=User,
    summary="Create a user",
    status_code=status.HTTP_201_CREATED,
)
async def create_user(payload: UserInput) -> User:
    """Create a new user and return the created record."""
    return store.create_user(payload)


@router.get(
    "/{id}",
    response_model=User,
    summary="Get a user by ID",
    status_code=status.HTTP_200_OK,
    responses={404: {"description": "User not found"}},
)
async def get_user(id: str = Path(..., description="The user's unique identifier")) -> User:
    """Return a single user by id, or 404 if not found."""
    user = store.get_user(id)
    if user is None:
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail="User not found")
    return user


@router.delete(
    "/{id}",
    summary="Delete a user",
    status_code=status.HTTP_204_NO_CONTENT,
    responses={404: {"description": "User not found"}},
)
async def delete_user(id: str = Path(..., description="The user's unique identifier")) -> Response:
    """Delete a user. Returns 204 on success, 404 if not found."""
    if not store.delete_user(id):
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail="User not found")
    return Response(status_code=status.HTTP_204_NO_CONTENT)
