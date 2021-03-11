import './App.css';
import './projectsFeed/ProjectsFeed.js'
import ProjectsFeed from "./projectsFeed/ProjectsFeed";
import Navbar from "./NavigationBar/NavBar";
import Filter from "./Filter/Filter";
import Groups from "./Groups/Groups";

function App() {
  return (
    <div className="App">
        <Navbar/>
        <div id='body_container'>
            <Filter/>
            <ProjectsFeed/>
            <Groups/>
        </div>
    </div>
  );
}

export default App;
