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
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import UserLogin from './components2/UserLogin';


const WelcomePage = ({ match }) => {
  return <h1>Welcome, {match.params.username}!</h1>;
};





function App() {
  const [post, setPost] = useState('');
  const [postList, setPostList] = useState([]);





  return (
    <div className="App">
  <Router>
      <Switch>
        <Route path="/login" component={UserLogin} />
        <Route path="/welcome/:username" component={WelcomePage} />
        {/* Add other routes here */}
      </Switch>
    </Router>

    <CreateUser2/>
    <NasaApi />
    {/* <ShowPosts setPost={setPost} /> */}
    {/* <MakePost post={post} /> */}
    {/* <MakeComment /> */}
    {/* <CommentSection /> */}
    <SaveComment />
    {/* <ShowUsers /> */}
    {/* <GetUserLink /> */}
    <UserPosts2 />
   
    
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
