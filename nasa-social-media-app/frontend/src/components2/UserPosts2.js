import React, { useState, useEffect } from 'react';



function UserPosts2() {
  const [posts, setPosts] = useState([]);  // Ensure it's an array initially
  const [activeTab, setActiveTab] = useState(null);

  // Fetch data from the backend
  useEffect(() => {
    fetch('http://localhost:8080/user-posts')
      .then((response) => response.json())
      .then((data) => {
        // Check if the response is an array before setting the state
        if (Array.isArray(data)) {
          setPosts(data);
        } else {
          console.error('Data is not an array:', data);
        }
      })
      .catch((error) => console.error('Error fetching posts:', error));
  }, []);

  // Handle tab click
  const handleTabClick = (index) => {
    setActiveTab(index);
  };

  return (
    <div>
      <h1>User Posts</h1>

      {/* CSS Styles */}
      <style>
        {`
          .tabs {
            display: flex;
            margin-bottom: 10px;
          }

          .tab {
            padding: 10px;
            margin-right: 5px;
            cursor: pointer;
            background-color: lightgray;
            border: 1px solid #ddd;
          }

          .tab.active {
            background-color: #3f72af;
            color: white;
          }

          .tab-content {
            padding: 10px;
            border: 1px solid #ddd;
            margin-top: 10px;
          }
        `}
      </style>

      {/* Tabs */}
      <div className="tabs">
        {Array.isArray(posts) &&
          posts.map((post, index) => (
            <button
              key={index}
              className={`tab ${activeTab === index ? 'active' : ''}`}
              onClick={() => handleTabClick(index)}
            >
              Post {index + 1}
            </button>
          ))}
      </div>

      {/* Display post data in active tab */}
      <div className="tab-content">
        {activeTab !== null && posts[activeTab] && (
          <div>
            <h2>{`Post ${activeTab + 1}`}</h2>
            <p>{posts[activeTab].content}</p> {/* Assuming each post has a 'content' field */}
          </div>
        )}
      </div>
    </div>
  );
}



export default UserPosts2;
