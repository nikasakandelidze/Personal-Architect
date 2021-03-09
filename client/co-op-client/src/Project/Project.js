import './Project.css'

function Project(props){
    return(
        <div className='project'>
            <h1>Name: {props.name}</h1>
            <h1>Link: {props.link}</h1>
            <h1>Description: {props.description}</h1>
        </div>
    );
}

export default Project;