import React from 'react';
import axios from 'axios';



function MakePost({ post }) {
    const savePost = () =>
        axios
        .post('http://localhost:8080/posts', { text: post})
        .then(() => alert('Post has been made!'));

    return <button onClick={savePost}>Post</button>
}

export default MakePost;