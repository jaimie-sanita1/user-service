const http = require("http");

// In-memory user store pre-seeded with sample data
let users = [
  { id: "1", name: "Alice Johnson", email: "alice@example.com", role: "admin", status: "active", createdAt: "2026-01-15T10:30:00.000Z" },
  { id: "2", name: "Bob Smith", email: "bob@example.com", role: "member", status: "active", createdAt: "2026-02-20T14:45:00.000Z" },
  { id: "3", name: "Carol Davis", email: "carol@example.com", role: "member", status: "inactive", createdAt: "2026-03-01T09:00:00.000Z" }
];

let nextId = 4;

function parseBody(req) {
  return new Promise((resolve, reject) => {
    let body = "";
    req.on("data", chunk => (body += chunk));
    req.on("end", () => {
      try {
        resolve(body ? JSON.parse(body) : {});
      } catch (e) {
        reject(e);
      }
    });
    req.on("error", reject);
  });
}

function sendJSON(res, statusCode, data) {
  res.writeHead(statusCode, { "Content-Type": "application/json" });
  res.end(JSON.stringify(data));
}

function extractUserId(url) {
  const match = url.match(/^\/users\/([^/?]+)/);
  return match ? match[1] : null;
}

const server = http.createServer(async (req, res) => {
  const { method } = req;
  const url = req.url.split("?")[0];

  // @endpoint GET /users
  if (method === "GET" && url === "/users") {
    sendJSON(res, 200, users);
    return;
  }

  // @endpoint POST /users
  if (method === "POST" && url === "/users") {
    try {
      const input = await parseBody(req);
      const newUser = {
        id: String(nextId++),
        name: input.name,
        email: input.email,
        role: input.role,
        status: input.status || "active",
        createdAt: new Date().toISOString()
      };
      users.push(newUser);
      sendJSON(res, 201, newUser);
    } catch (e) {
      sendJSON(res, 400, { error: "Invalid request body" });
    }
    return;
  }

  // @endpoint GET /users/:id
  if (method === "GET" && url.match(/^\/users\/[^/?]+$/)) {
    const id = extractUserId(url);
    const user = users.find(u => u.id === id);
    if (user) {
      sendJSON(res, 200, user);
    } else {
      sendJSON(res, 404, { error: "User not found" });
    }
    return;
  }

  // @endpoint PUT /users/:id
  if (method === "PUT" && url.match(/^\/users\/[^/?]+$/)) {
    const id = extractUserId(url);
    const index = users.findIndex(u => u.id === id);
    if (index === -1) {
      sendJSON(res, 404, { error: "User not found" });
      return;
    }
    try {
      const input = await parseBody(req);
      users[index] = {
        ...users[index],
        name: input.name !== undefined ? input.name : users[index].name,
        email: input.email !== undefined ? input.email : users[index].email,
        role: input.role !== undefined ? input.role : users[index].role,
        status: input.status !== undefined ? input.status : users[index].status
      };
      sendJSON(res, 200, users[index]);
    } catch (e) {
      sendJSON(res, 400, { error: "Invalid request body" });
    }
    return;
  }

  // @endpoint DELETE /users/:id
  if (method === "DELETE" && url.match(/^\/users\/[^/?]+$/)) {
    const id = extractUserId(url);
    const index = users.findIndex(u => u.id === id);
    if (index === -1) {
      sendJSON(res, 404, { error: "User not found" });
      return;
    }
    users.splice(index, 1);
    res.writeHead(204);
    res.end();
    return;
  }

  // Fallback for unmocked routes
  sendJSON(res, 404, { error: "Mock route not defined", method, url });
});

const PORT = process.env.PORT || 3000;
server.listen(PORT);
