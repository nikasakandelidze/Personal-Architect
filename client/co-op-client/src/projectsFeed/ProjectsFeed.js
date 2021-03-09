
import data from './projects.json'
import Project from "../Project/Project";

function ProjectsFeed(){
    return (
        <div>
            {data.map(element => <Project name={element.name} link={element.link}/>)}
        </div>
    );
}

export default ProjectsFeed;