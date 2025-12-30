import { useEffect, useState } from "react";
import axios from "axios";

const ShowUsers = ({ username }) => {
  const [data, setData] = useState(null);

  useEffect(() => {
    axios
      .get(`http://localhost:3000/profile/${username}`) // Dynamic path variable
      .then((response) => setData(response.data))
      .catch((error) => console.error("Error fetching data:", error));
  }, [username]);

  return <div>{data ? <p>{JSON.stringify(data)}</p> : <p>Loading...</p>}</div>;
};

export default ShowUsers;
