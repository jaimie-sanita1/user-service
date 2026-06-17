"""
Shared dependencies: bearer-token auth (matches the `bearerAuth` security scheme
declared in users.yaml).

This is a stub: it accepts any non-empty bearer token. Replace `verify_bearer_token`
with real JWT validation (e.g., python-jose / authlib) before going to production.
"""

from fastapi import Depends, HTTPException, status
from fastapi.security import HTTPAuthorizationCredentials, HTTPBearer

bearer_scheme = HTTPBearer(auto_error=False)


async def verify_bearer_token(
    credentials: HTTPAuthorizationCredentials | None = Depends(bearer_scheme),
) -> str:
    """Validate a bearer token and return the token string.

    Raises 401 if the token is missing or empty. Replace the body with real
    JWT verification when integrating with your identity provider.
    """
    if credentials is None or not credentials.credentials:
        raise HTTPException(
            status_code=status.HTTP_401_UNAUTHORIZED,
            detail="Missing or invalid bearer token",
            headers={"WWW-Authenticate": "Bearer"},
        )

    # TODO: replace with real JWT verification (signature, exp, iss, aud, etc.)
    token = credentials.credentials
    return token
