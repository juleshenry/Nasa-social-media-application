import logo from './logo.svg';
import './App.css';
import NasaApi from './components/NasaApi';
import { useState } from 'react';
import MakePost from './components/MakePost';
import ShowPosts from './components/ShowPosts';
import NewApp from './components/NewApp.css';
import MakeComment from './components/MakeComment';
import CreateUser from './components/CreateUser';
import CommentSection from './components/CommentSection';
import SaveComment from './components/SaveComment';
import ShowUsers from './components/ShowUsers';
import GetUserLink from './components/GetUserLink';
import UserPosts from './components/UserPosts';
import UserPosts2 from './components2/UserPosts2';
import CreateUser2 from './components2/CreateUser2';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'; 
import UserLogin from './components2/UserLogin';
import { useParams } from 'react-router-dom';
import ShowAllPosts from './components2/ShowAllPosts';
import ShowAllPosts2 from './components2/ShowAllPosts2';
import GetPostData from './components2/GetPostData';
import ProfileLogin from './components2/ProfileLogin';
import LoginForm from './components2/LoginForm';
import Welcome from './components2/Welcome';
import LoginFetchData from './components2/LoginDataFetch';
// import MainLogin from './components2/MainLogin';

// const WelcomePage = () => {
//   const { username } = useParams();  // Access the "username" param from the URL

//   return <h1>Welcome, {username}!</h1>;
// };





function App() {
  const [post, setPost] = useState('');
  const [postList, setPostList] = useState([]);





  return (
    <div className="App">
  <Router>
      <Routes>  {/* Use Routes instead of Switch */}
        <Route path="/" element={<LoginForm />} />
        <Route path="/profile/:username" element={<Welcome />} />
        {/* Add other routes here */}
      </Routes>
    </Router>
    
    

    <CreateUser2/>
    <LoginFetchData/>
    <NasaApi />
    {/* <ShowPosts setPost={setPost} /> */}
    {/* <MakePost post={post} /> */}
    {/* <MakeComment /> */}
    {/* <CommentSection /> */}
    <SaveComment />
    {/* <ShowUsers /> */}
    {/* <GetUserLink /> */}
    {/* <UserPosts2 /> */}
    {/* <ShowAllPosts/> */}
    {/* <ShowAllPosts2 /> */}
    <GetPostData />
    
    
    </div>
  );
}



// function App() {
//   return (
//     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <p>
//           Edit <code>src/App.js</code> and save to reload.
//         </p>
//         <a
//           className="App-link"
//           href="https://reactjs.org"
//           target="_blank"
//           rel="noopener noreferrer"
//         >
//           Learn React
//         </a>
//       </header>
//     </div>
//   );
// }

export default App;
