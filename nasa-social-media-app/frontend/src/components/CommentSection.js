import { useState } from "react";

function CommentSection() {
  const [username, setUsername] = useState("");
  const [comment, setComment] = useState("");
  const [comments, setComments] = useState([]);

  const handleSubmit = (e) => {
    e.preventDefault();
    if (username.trim() && comment.trim()) {
      setComments([...comments, { username, text: comment }]);
      setUsername("");
      setComment("");
    }
  };

  return (
    <div style={styles.container}>
      <h2 style={styles.heading}>Comment Section</h2>

      {/* Comment Input Form */}
      <form onSubmit={handleSubmit} style={styles.form}>
        <input
          type="text"
          placeholder="Username"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
          style={styles.input}
        />
        <textarea
          placeholder="Write a comment..."
          value={comment}
          onChange={(e) => setComment(e.target.value)}
          style={{ ...styles.input, height: "80px" }}
        />
        <button type="submit" style={styles.button}>
          Post Comment
        </button>
      </form>

      {/* Display Comments */}
      <div>
        {comments.map((c, index) => (
          <div key={index} style={styles.comment}>
            <strong style={styles.username}>{c.username}</strong>
            <p style={styles.commentText}>{c.text}</p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default CommentSection;

// Inline styles
const styles = {
  container: {
    maxWidth: "500px",
    margin: "20px auto",
    padding: "20px",
    background: "#f4f4f4",
    borderRadius: "8px",
    boxShadow: "2px 2px 10px rgba(0, 0, 0, 0.1)",
  },
  heading: {
    textAlign: "center",
    marginBottom: "15px",
  },
  form: {
    display: "flex",
    flexDirection: "column",
    gap: "10px",
  },
  input: {
    width: "100%",
    padding: "10px",
    border: "1px solid #ccc",
    borderRadius: "5px",
    fontSize: "14px",
    maxWidth: "500px"
  },
  button: {
    background: "#007bff",
    color: "white",
    border: "none",
    padding: "10px",
    borderRadius: "5px",
    cursor: "pointer",
    fontSize: "14px",
  },
  comment: {
    background: "white",
    padding: "10px",
    borderRadius: "5px",
    marginBottom: "10px",
    borderLeft: "4px solid #007bff",
  },
  username: {
    color: "#007bff",
    fontWeight: "bold",
  },
  commentText: {
    marginTop: "5px",
  },
};
