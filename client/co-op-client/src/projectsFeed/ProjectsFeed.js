
import data from './projects.json'
import ProjectProxy from "../Project/ProjectProxy";

//import css
import './ProjectsFeed.css'
import Project from "../Project/Project";

function ProjectsFeed(){

    return (
        <div className='projects_feed_container'>
            {data.map( (element,index) => {
                return <ProjectProxy name={element.name} link={element.link} description={element.description} id={index}/>;
            })}
        </div>
    );
}

export default ProjectsFeed;