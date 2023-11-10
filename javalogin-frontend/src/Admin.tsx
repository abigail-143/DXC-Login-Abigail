import { useContext, useEffect, useRef, useState } from "react";
import { useNavigate } from "react-router-dom";
import UserContext from "./context/UserContext";
import useFetch from "./hooks/useFetch";
import "./App.css";

interface props {
  setPage: React.Dispatch<React.SetStateAction<string>>;
}

function Admin(props: props) {
  const fetchData = useFetch();
  const navigate = useNavigate();
  const context = useContext(UserContext);
  const usernameRef = useRef<HTMLInputElement | null>(null);
  const passwordRef = useRef<HTMLInputElement | null>(null);
  const [clearance, setClearance] = useState<string>("USER");
  const [message, setMessage] = useState<string>("");
  const [userList, setUserList] = useState<
    {
      user_id: string;
      username: string;
      password: string;
      clearance: string;
    }[]
  >([]);

  const getAllUsers = async () => {
    const res = await fetchData("/all", "GET", undefined, undefined, undefined);

    if (res.ok) {
      setUserList(res.data);
    } else {
      alert(res.data.response);
    }
  };

  const handleClick = () => {
    props.setPage("main");
    navigate("/");
  };

  const registerUser = async () => {
    if (usernameRef.current && passwordRef.current) {
      const res = await fetchData("/register", "POST", undefined, undefined, {
        username: usernameRef.current.value,
        password: passwordRef.current.value,
        clearance: clearance.toUpperCase(),
      });

      if (res.ok) {
        usernameRef.current.value = "";
        passwordRef.current.value = "";
        setClearance("USER");
        setMessage(res.data.response);
        getAllUsers();
        // this will clear the message
        setInterval(() => setMessage(""), 1000);
      } else {
        alert(res.data.response);
      }
    }
  };

  useEffect(() => {
    getAllUsers();
  }, []);

  return (
    <>
      <h1>Welcome {context?.username.toUpperCase()}!</h1>
      <button onClick={handleClick}>Logout</button>
      <div className="form">
        <h2>Register New User Here</h2>
        <div className="row">
          <label>Username</label>
          <input placeholder="username" ref={usernameRef}></input>
        </div>
        <div className="row">
          <label>Password</label>
          <input placeholder="password" ref={passwordRef}></input>
        </div>
        <div className="row">
          <select
            name="clearance"
            id="clearance"
            onChange={(e) => {
              setClearance(e.target.value);
            }}
            defaultValue={"USER"}
          >
            <option value="USER">User</option>
            <option value="ADMIN">Admin</option>
          </select>
        </div>
        <button onClick={registerUser}>Register</button>
        <div>
          <p className="error">{message}</p>
        </div>
      </div>
      <div>
        <h2>Existing Users</h2>
        <ul className="userlist">
          {userList
            .slice()
            .reverse()
            .map((item, index) => {
              return (
                <li key={index}>
                  {item.username}, {item.clearance}
                </li>
              );
            })}
        </ul>
      </div>
    </>
  );
}

export default Admin;
