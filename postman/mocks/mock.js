const http = require("http");

const SECURITY_HEADERS = {
  "Content-Type": "application/json",
  "X-Content-Type-Options": "nosniff",
  "X-Frame-Options": "DENY",
};

function sendJSON(res, statusCode, body) {
  const payload = JSON.stringify(body);
  res.writeHead(statusCode, SECURITY_HEADERS);
  res.end(payload);
}

function sendEmpty(res, statusCode) {
  res.writeHead(statusCode, {
    "X-Content-Type-Options": "nosniff",
    "X-Frame-Options": "DENY",
  });
  res.end();
}

function readBody(req) {
  return new Promise((resolve, reject) => {
    let data = "";
    req.on("data", (chunk) => (data += chunk));
    req.on("end", () => {
      try {
        resolve(data ? JSON.parse(data) : {});
      } catch (e) {
        reject(e);
      }
    });
    req.on("error", reject);
  });
}

function sanitizeUser(user) {
  // Omit sensitive fields (e.g. password, passwordHash, secret)
  const { password, passwordHash, secret, ...safe } = user;
  return safe;
}

function generateId() {
  return (
    Math.random().toString(36).substring(2, 10) +
    Math.random().toString(36).substring(2, 10)
  );
}

const server = http.createServer(async (req, res) => {
  const method = req.method.toUpperCase();
  const rawUrl = req.url || "/";
  const urlObj = new URL(rawUrl, "http://localhost");
  const pathname = urlObj.pathname;

  // @endpoint GET /users
  // Route: GET /users
  if (method === "GET" && pathname === "/users") {
    const users = (await pm.state.get("users-mock:users")) || [];
    sendJSON(res, 200, users.map(sanitizeUser));
    return;
  }

  // @endpoint POST /users
  // Route: POST /users
  if (method === "POST" && pathname === "/users") {
    let body;
    try {
      body = await readBody(req);
    } catch (e) {
      sendJSON(res, 400, { error: "Invalid JSON body" });
      return;
    }

    if (!body.name || !body.email) {
      sendJSON(res, 400, { error: "name and email are required" });
      return;
    }

    const users = (await pm.state.get("users-mock:users")) || [];
    const now = new Date().toISOString();
    const newUser = {
      id: generateId(),
      name: body.name,
      email: body.email,
      status: body.status || "active",
      createdAt: now,
      updatedAt: now,
    };
    users.push(newUser);
    await pm.state.set("users-mock:users", users);
    sendJSON(res, 201, sanitizeUser(newUser));
    return;
  }

  // @endpoint GET /users/:id
  // Route: GET /users/:id
  const idMatchGet = pathname.match(/^\/users\/([^/]+)$/);
  if (method === "GET" && idMatchGet) {
    const id = idMatchGet[1];
    const users = (await pm.state.get("users-mock:users")) || [];
    const user = users.find((u) => u.id === id);
    if (!user) {
      sendJSON(res, 404, { error: "User not found" });
      return;
    }
    sendJSON(res, 200, sanitizeUser(user));
    return;
  }

  // @endpoint PUT /users/:id
  // Route: PUT /users/:id
  const idMatchPut = pathname.match(/^\/users\/([^/]+)$/);
  if (method === "PUT" && idMatchPut) {
    const id = idMatchPut[1];
    let body;
    try {
      body = await readBody(req);
    } catch (e) {
      sendJSON(res, 400, { error: "Invalid JSON body" });
      return;
    }

    const users = (await pm.state.get("users-mock:users")) || [];
    const idx = users.findIndex((u) => u.id === id);
    if (idx === -1) {
      sendJSON(res, 404, { error: "User not found" });
      return;
    }

    const now = new Date().toISOString();
    // Only allow updating mutable fields; id and createdAt are immutable
    const updatable = ["name", "email", "status"];
    updatable.forEach((field) => {
      if (body[field] !== undefined) {
        users[idx][field] = body[field];
      }
    });
    users[idx].updatedAt = now;
    await pm.state.set("users-mock:users", users);
    sendJSON(res, 200, sanitizeUser(users[idx]));
    return;
  }

  // @endpoint DELETE /users/:id
  // Route: DELETE /users/:id
  const idMatchDelete = pathname.match(/^\/users\/([^/]+)$/);
  if (method === "DELETE" && idMatchDelete) {
    const id = idMatchDelete[1];
    const users = (await pm.state.get("users-mock:users")) || [];
    const idx = users.findIndex((u) => u.id === id);
    if (idx === -1) {
      sendJSON(res, 404, { error: "User not found" });
      return;
    }
    users.splice(idx, 1);
    await pm.state.set("users-mock:users", users);
    sendEmpty(res, 204);
    return;
  }

  // NOTE: POST /users/:id is intentionally excluded — it is a placeholder
  // artifact in the generated collection and has no grounded behavior.

  // 404 fallback
  sendJSON(res, 404, { error: "Not found" });
});

server.listen(process.env.PORT || 3000, () => {
  console.log(`users-mock listening on port ${process.env.PORT || 3000}`);
});
