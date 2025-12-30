import React, { useEffect, useState } from 'react';
import axios from 'axios';

function ShowAllPosts() {
  const [data, setData] = useState(null);

  useEffect(() => {
    // Make the GET request
    axios.get('http://localhost:8080/user-posts')
      .then(response => setData(response.data))  // Set the data to state
      .catch(error => console.error('Error fetching data:', error));
  }, []);

  return (
    <div>
      <h1>Data from API</h1>
      <pre>{JSON.stringify(data, null, 2)}</pre> {/* Display the data in a formatted way */}
    </div>
  );
}

export default ShowAllPosts;
