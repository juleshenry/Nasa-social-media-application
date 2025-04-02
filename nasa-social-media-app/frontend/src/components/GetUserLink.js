import { useEffect } from "react";

function GetUserLink() {
    useEffect(() => {
        fetch("http://localhost:3000/", {
            method: "GET",
            credentials: "include", // Important if using session-based authentication
        })
        .then(response => {
            if (response.redirected) {
                window.location.href = response.url; // Redirect to the resolved URL
            }
        })
        .catch(error => console.error("Error:", error));
    }, []);

    
}



export default GetUserLink;
