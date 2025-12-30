import { useState } from "react";
import axios from 'axios';
import React from 'react';

const MakeComment = () => {
  const [comments, setComments] = useState([]);
  const [newComment, setNewComment] = useState("");

  // Handle input change
  const handleInputChange = (event) => {
    setNewComment(event.target.value);
  };

  // Handle adding a comment
//   const addComment = () => {
//     if (newComment.trim() === "") return;

    const savePost = () => {
        axios
        .post('http://localhost:8080/posts', { text: newComment})
        .then(() => alert('Post has been made!'));
        if (newComment.trim() === "") return;

    setComments([...comments, newComment]); // Add new comment to list
    setNewComment(""); // Clear input field
  };

  

  return (
    <div className="max-w-lg mx-auto p-4 border rounded-lg shadow-md">
      <h2 className="text-xl font-semibold mb-3">Comments</h2>

      {/* Input for new comment */}
      <div className="flex space-x-2 mb-3">
        <input
          type="text"
          value={newComment}
          onChange={handleInputChange}
          placeholder="Write a comment..."
          className="border p-2 flex-grow rounded-md"
        />
        <button
          onClick={savePost}
          className="bg-blue-500 text-white px-3 py-2 rounded-md hover:bg-blue-600">Add</button>
      </div>

      {/* Display comments */}
      <ul className="space-y-2">
        {comments.map((comment, index) => (
          <li key={index} className="border p-2 rounded-md">
            {comment}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default MakeComment;
