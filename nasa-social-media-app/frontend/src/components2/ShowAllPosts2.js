import React, { useEffect, useState } from 'react';

const ShowAllPosts2 = () => {
  const [data, setData] = useState({ id: '',userIdentifier: '', text: '' });
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    // Fetch data when the component mounts with credentials included
    fetch('http://localhost:8080/users/posts', {
      method: 'GET'
      // credentials: 'include', // Include cookies or HTTP authentication
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then((data) => {
        // Assuming your response has username and text properties
        setData({ id: data.id,userIdentifier: data.userIdentifier, text: data.text });
        setLoading(false);
      })
      .catch((error) => {
        setError(error.message);
        setLoading(false);
      });
  }, []); // Empty dependency array ensures this runs only once on mount

  if (loading) {
    return <p>Loading...</p>;
  }

  if (error) {
    return <p>Error: {error}</p>;
  }




  return (
    <div>
      <p> Id: {data.id}</p>
      <p>Username: {data.userIdentifier}</p>
      <p>Text: {data.text}</p>
    </div>
  );
};





export default ShowAllPosts2;
