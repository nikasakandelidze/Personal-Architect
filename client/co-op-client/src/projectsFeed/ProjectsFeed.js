
import data from './projects.json'
import ProjectProxy from "../Project/ProjectProxy";

//import css
import './ProjectsFeed.css'

function ProjectsFeed(){
    return (
        <div className='projects_feed_container'>
            {data.map(element => <ProjectProxy name={element.name} link={element.link} description={element.description} />)}
        </div>
    );
}

export default ProjectsFeed;