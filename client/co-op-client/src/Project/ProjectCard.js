import './ProjectCard.css'
import {useState} from "react";

function ProjectCard(props){
    const [fullcard, setFullcard]=useState(false);

    return(
        <div id={`${props.id}_project_card`} className={`${fullcard ? 'full':'half'}_project_card_container`} onClick={()=>fullcard? setFullcard(false) : setFullcard(true)}>
            <h1>Name: {props.name}</h1>
            <h1>Description: {props.description}</h1>
            <h1>Link: {props.link}</h1>
        </div>
    );
}

export default ProjectCard;