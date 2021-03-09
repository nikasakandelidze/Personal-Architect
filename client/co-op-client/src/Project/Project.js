import './Project.css'

function Project(props){
    return(
        <div className='project_container'>
            <h1>Name: {props.name}</h1>
            <h1>Link: {props.link}</h1>
        </div>
    );
}

export default Project;