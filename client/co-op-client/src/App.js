import './App.css';
import './projectsFeed/ProjectsFeed.js'
import ProjectsFeed from "./projectsFeed/ProjectsFeed";
import Navbar from "./NavigationBar/NavBar";

function App() {
  return (
    <div className="App">
        <Navbar/>
        <ProjectsFeed/>
    </div>
  );
}

export default App;
