import React from 'react';
import axios from 'axios';

function ShowPosts({ setPost }) {
    // anonymous function aka lambda
    const fetchPosts = () => 
        axios.get('http://localhost:3000/users/posts')
        .then(response => setPost(response.data.value));

    return <button onClick={fetchPosts}>Get Posts</button>
}

export default ShowPosts;