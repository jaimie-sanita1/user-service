# Users API — FastAPI server

A Python/FastAPI implementation generated from [`users.yaml`](../users.yaml).

## Layout

```
src/
  main.py        # FastAPI app + router wiring
  models.py      # Pydantic models (User, UserInput, Role, Status)
  deps.py        # Bearer-token auth dependency (stub)
  store.py       # In-memory user store (stub, with seed data)
  routes/
    users.py     # /users and /users/{id} handlers
```

## Endpoints

| Method | Path           | Summary           | Auth   |
| ------ | -------------- | ----------------- | ------ |
| GET    | `/users`       | List all users    | Bearer |
| POST   | `/users`       | Create a user     | Bearer |
| GET    | `/users/{id}`  | Get a user by ID  | Bearer |
| DELETE | `/users/{id}`  | Delete a user     | Bearer |
| GET    | `/health`      | Liveness probe    | None   |

## Run locally

From the repo root:

```bash
python -m venv .venv
source .venv/bin/activate
pip install -r requirements.txt
uvicorn src.main:app --reload
```

Interactive docs at <http://localhost:8000/docs>.

## Try it

```bash
# List (any non-empty bearer token works in the stub)
curl -H "Authorization: Bearer dev-token" http://localhost:8000/users

# Create
curl -X POST http://localhost:8000/users \
  -H "Authorization: Bearer dev-token" \
  -H "Content-Type: application/json" \
  -d '{"name":"Ada","email":"ada@example.com","role":"admin"}'

# Get by id
curl -H "Authorization: Bearer dev-token" http://localhost:8000/users/u_1

# Delete
curl -X DELETE -H "Authorization: Bearer dev-token" http://localhost:8000/users/u_1
```

## What's a stub vs. what's real

- **Real:** Pydantic models, routing, status codes, error responses, and the OpenAPI doc all match `users.yaml`.
- **Stubbed:** `deps.verify_bearer_token` accepts any non-empty token — wire up real JWT validation before deploying. `store.UserStore` is in-memory and resets on restart — swap for a real database.
