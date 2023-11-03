import { useContext } from "react";
import { useNavigate } from "react-router-dom";
import UserContext from "./context/UserContext";
import "./App.css";

interface props {
  setPage: React.Dispatch<React.SetStateAction<string>>;
}

function User(props: props) {
  const navigate = useNavigate();
  const context = useContext(UserContext);

  const handleClick = () => {
    props.setPage("main");
    navigate("/");
  };
  return (
    <>
      <h1>Welcome {context?.username.toUpperCase()}!</h1>
      <button onClick={handleClick}>Logout</button>
    </>
  );
}

export default User;
