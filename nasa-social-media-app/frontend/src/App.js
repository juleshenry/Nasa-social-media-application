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

function App() {
  const [post, setPost] = useState('');
  const [postList, setPostList] = useState([]);

  return (
    <div className="App">

    <CreateUser />
    <NasaApi />
    {/* <ShowPosts setPost={setPost} /> */}
    {/* <MakePost post={post} /> */}
    {/* <MakeComment /> */}
    <CommentSection />
    <SaveComment />
    <ShowUsers />
    <GetUserLink />

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
