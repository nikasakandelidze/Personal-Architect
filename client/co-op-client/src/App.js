import './App.css';
import './projectsFeed/ProjectsFeed.js'
import ProjectsFeed from "./projectsFeed/ProjectsFeed";
import Filter from "./Filter/Filter";
import Popular from "./Popular/Popular";
import Navbar from "./NavigationBar/NavBar";
function App() {
  return (
    <div className="App">
        <Navbar/>
        <div id='body_container'>
            <Filter/>
            <ProjectsFeed/>
            <Popular/>
        </div>
    </div>
  );
}

export default App;
