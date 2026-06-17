"""
In-memory user store used by the stub handlers.

Replace with a real persistence layer (Postgres, DynamoDB, etc.) when wiring
up production code. Kept intentionally tiny and dependency-free so the server
boots out of the box.
"""

from __future__ import annotations

from datetime import datetime, timezone
from typing import Dict
from uuid import uuid4

from .models import Role, Status, User, UserInput


class UserStore:
    def __init__(self) -> None:
        self._users: Dict[str, User] = {}
        self._seed()

    def _seed(self) -> None:
        seed_users = [
            User(
                id="u_1",
                name="Ada Lovelace",
                email="ada@example.com",
                role=Role.admin,
                status=Status.active,
                createdAt=datetime(2026, 1, 1, 12, 0, 0, tzinfo=timezone.utc),
            ),
            User(
                id="u_2",
                name="Grace Hopper",
                email="grace@example.com",
                role=Role.member,
                status=Status.active,
                createdAt=datetime(2026, 1, 2, 9, 30, 0, tzinfo=timezone.utc),
            ),
        ]
        for u in seed_users:
            self._users[u.id] = u

    def list_users(self) -> list[User]:
        return list(self._users.values())

    def get_user(self, user_id: str) -> User | None:
        return self._users.get(user_id)

    def create_user(self, payload: UserInput) -> User:
        new_id = f"u_{uuid4().hex[:8]}"
        user = User(
            id=new_id,
            name=payload.name,
            email=payload.email,
            role=payload.role,
            status=payload.status or Status.active,
            createdAt=datetime.now(timezone.utc),
        )
        self._users[new_id] = user
        return user

    def delete_user(self, user_id: str) -> bool:
        return self._users.pop(user_id, None) is not None


# Module-level singleton; FastAPI dependencies pull from this.
store = UserStore()
