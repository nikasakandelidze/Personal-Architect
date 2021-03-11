
import data from './projects.json'
import ProjectCard from "../Project/ProjectCard";

//import css
import './ProjectsFeed.css'

function ProjectsFeed(){

    return (
        <div >
            <div>
                <h3>Projects feed</h3>
            </div>
            <div className='projects_feed_container'>
                {data.map( (element,index) => {
                    return <ProjectCard name={element.name} link={element.link} description={element.description} id={index}/>;
                })}
            </div>
        </div>
    );
}

export default ProjectsFeed;