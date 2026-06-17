"""
FastAPI application entry point for the Users API.

Generated from users.yaml. Run locally with:

    uvicorn src.main:app --reload

Interactive docs: http://localhost:8000/docs
"""

from fastapi import FastAPI

from .routes import users as users_routes

app = FastAPI(
    title="Users API",
    description="API for application users",
    version="1.0.0",
)


@app.get("/health", tags=["meta"], summary="Liveness probe")
async def health() -> dict[str, str]:
    return {"status": "ok"}


app.include_router(users_routes.router)
