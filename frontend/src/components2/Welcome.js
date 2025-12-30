import React from 'react';
import { useParams } from 'react-router-dom'; // Import useParams

const Welcome = () => {
  const { username } = useParams(); // Extract username from URL

  return (
    <div>
      <h1>Welcome, {username}!</h1> {/* Display username */}
    </div>
  );
};

export default Welcome;
