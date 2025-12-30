import React, { useState, useEffect } from 'react';
import axios from 'axios';





const NasaApi = () => {
    const [photoData, setPhotoData] = useState(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);


    useEffect(() => {
        axios.get('https://api.nasa.gov/planetary/apod?api_key=MxStSjX322uwkKyz539Z3NIOx67fhhpZe2iNCggL')
        .then((response) => {
          setPhotoData(response.data);
          setLoading(false);
        })
        .catch((error) => {
          setError(error.toString());
          setLoading(false);
        });
    }, []);




    return (
        <div>
          {loading && <p>Loading...</p>}
          {error && <p>Error: {error}</p>}
          {photoData && (
            <div>
              <h1>{photoData.title}</h1>
              <img src={photoData.hdurl} alt={photoData.title} width={300}/>
              <p>{photoData.explanation}</p>
            </div>
          )}
        </div>
      );
    };



export default NasaApi;  