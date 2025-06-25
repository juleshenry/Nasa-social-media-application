import React, { useEffect, useState } from 'react';

const GetPostData = () => {
  // State now holds an array of objects with id, username, and text attributes
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    // Fetch data when the component mounts
    fetch('http://localhost:8080/users/posts', {
      method: 'GET'
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json(); // Parse the response as JSON
      })
      .then((data) => {
        // Assuming the data is an array of objects with id, username, and text attributes
        setData(data); // Set the array of data in the state
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

//   return (
//     <div>
//       {/* Map over the array of data and render each item */}
//       {data.map((item) => (
//         <div key={item.id}>
//          <p id={`text-${item.id}`}>Text: {item.text}</p>
//          <p id={`userIdentifier-${item.id}`}>Username: {item.userIdentifier}</p>
//         </div>
//       ))}
//     </div>
//   );
// };

return (
    <div style={styles.cardContainer}>
      {/* Map over the array of data and render each item as a card */}
      {data.map((item) => (
        <div key={item.id} style={styles.card}>
          <h3 style={styles.cardUsername}>{item.userIdentifier}</h3>
          <p style={styles.cardText}>{item.text}</p>
        </div>
      ))}
    </div>
  );
};

const styles = {
    cardContainer: {
      display: 'flex',
      flexWrap: 'wrap',
      gap: '20px',
      justifyContent: 'center',
      padding: '20px',
    },
    card: {
      backgroundColor: '#fff',
      borderRadius: '8px',
      boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)',
      width: '250px',
      padding: '15px',
      textAlign: 'center',
      transition: 'transform 0.3s ease',
    },
    cardHover: {
      transform: 'translateY(-5px)',
    },
    cardUsername: {
      fontSize: '1.2rem',
      fontWeight: 'bold',
      marginBottom: '10px',
    },
    cardText: {
      fontSize: '1rem',
      color: '#555',
    },
  };
  






export default GetPostData;
