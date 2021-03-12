
import data from './projects.json'
import ProjectCard from "../Project/ProjectCard";

//import css
import './ProjectsFeed.css'
import Filter from "../Filter/Filter";

function ProjectsFeed(){

    return (
        <div>
            <div className='projects_feed_container'>
                <div id='projects_feed_title'>
                    <h3>Projects feed</h3>
                </div>
                {data.map( (element,index) => {
                    return <ProjectCard name={element.name} link={element.link} description={element.description} id={index}/>;
                })}
            </div>
        </div>
    );
}

export default ProjectsFeed;