import { useContext, useRef, useState } from "react";
import { useNavigate } from "react-router-dom";
import useFetch from "./hooks/useFetch";
import UserContext from "./context/UserContext";

interface props {
  setPage: React.Dispatch<React.SetStateAction<string>>;
}

function Login(props: props) {
  const fetchData = useFetch();
  const navigate = useNavigate();
  const context = useContext(UserContext);
  const usernameRef = useRef<HTMLInputElement | null>(null);
  const passwordRef = useRef<HTMLInputElement | null>(null);
  const [error, setError] = useState<string>("");

  const handleClick = () => {
    props.setPage("main");
    navigate("/");
  };

  const handleLogin = async () => {
    if (usernameRef.current && passwordRef.current) {
      const res = await fetchData("/login", "POST", undefined, undefined, {
        username: usernameRef.current.value,
        password: passwordRef.current.value,
      });

      if (res.ok) {
        context?.setUsername(res.data.username);
        context?.setAccessToken(res.data.accessToken);
        context?.setClearance(res.data.clearance);

        if (res.data.clearance === "ADMIN") {
          props.setPage("admin");
          navigate("/admin");
        } else {
          props.setPage("user");
          navigate("/user");
        }
      } else {
        setError(res.data);
        usernameRef.current.value = "";
        passwordRef.current.value = "";
      }
    }
  };

  return (
    <>
      <h1>Login Here</h1>
      <div className="loginform">
        <div className="row">
          <label>Username</label>
          <input
            placeholder="username"
            ref={usernameRef}
            onChange={() => {
              setError("");
            }}
          ></input>
        </div>
        <div className="row">
          <label>Password</label>
          <input placeholder="password" ref={passwordRef}></input>
        </div>
        <div>
          <p className="error">{error}</p>
        </div>
      </div>

      <button onClick={handleClick}>back</button>
      <button onClick={handleLogin}>Login</button>
    </>
  );
}

export default Login;
