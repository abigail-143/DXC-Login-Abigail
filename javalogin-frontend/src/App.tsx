import { useState, Suspense } from "react";
import { Route, Routes, useNavigate } from "react-router-dom";
import "./App.css";
import Login from "./Login";
import User from "./User";
import Admin from "./Admin";
import UserContext from "./context/UserContext";

function App() {
  const [page, setPage] = useState<string>("main");
  const [username, setUsername] = useState<string>("");
  const [accessToken, setAccessToken] = useState<string>("");
  const [clearance, setClearance] = useState<string>("");
  const navigate = useNavigate();

  const handleClick = () => {
    setPage("login");
    navigate("/login");
  };

  return (
    <>
      <UserContext.Provider
        value={{
          username,
          setUsername,
          accessToken,
          setAccessToken,
          clearance,
          setClearance,
        }}
      >
        <Suspense>
          <Routes>
            <Route
              path="/"
              element={
                <>
                  <h1>Hello World</h1>
                  <button onClick={handleClick}>Login</button>
                </>
              }
            ></Route>
            {page === "login" && (
              <Route
                path="/login"
                element={<Login setPage={setPage}></Login>}
              ></Route>
            )}
            {page === "user" && (
              <Route
                path="/user"
                element={<User setPage={setPage}></User>}
              ></Route>
            )}
            {page === "admin" && (
              <Route
                path="/admin"
                element={<Admin setPage={setPage}></Admin>}
              ></Route>
            )}
          </Routes>
        </Suspense>
      </UserContext.Provider>
    </>
  );
}

export default App;
