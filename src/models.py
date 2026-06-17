"""
Pydantic models generated from users.yaml (OpenAPI 3.0).

Schemas:
- User: Full user representation returned by the API.
- UserInput: Payload for creating a user (POST /users).
"""

from __future__ import annotations

from datetime import datetime
from enum import Enum
from typing import Optional

from pydantic import BaseModel, EmailStr, Field


class Role(str, Enum):
    admin = "admin"
    member = "member"


class Status(str, Enum):
    active = "active"
    inactive = "inactive"
    suspended = "suspended"


class User(BaseModel):
    """Full user object returned by the API."""

    id: str = Field(..., description="Unique identifier for the user")
    name: str
    email: EmailStr
    role: Role
    status: Status
    createdAt: datetime

    model_config = {
        "json_schema_extra": {
            "example": {
                "id": "u_123",
                "name": "Ada Lovelace",
                "email": "ada@example.com",
                "role": "admin",
                "status": "active",
                "createdAt": "2026-01-01T12:00:00Z",
            }
        }
    }


class UserInput(BaseModel):
    """Payload for creating a user. `status` is optional and defaults to active."""

    name: str
    email: EmailStr
    role: Role
    status: Optional[Status] = Field(
        default=Status.active,
        description="Optional; defaults to active if omitted",
    )

    model_config = {
        "json_schema_extra": {
            "example": {
                "name": "Ada Lovelace",
                "email": "ada@example.com",
                "role": "admin",
                "status": "active",
            }
        }
    }
