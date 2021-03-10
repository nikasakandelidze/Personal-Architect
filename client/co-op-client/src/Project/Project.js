import './Project.css'
import {useState} from "react/cjs/react.production.min";

function Project(props) {
    return (
        <div>
            {props.visible &&
            <div className='project'>
                <h1>Name: {props.name}</h1>
                <h1>Link: {props.link}</h1>
                <h1>Description: {props.description}</h1>
            </div>}
        </div>
    );
}

export default Project;