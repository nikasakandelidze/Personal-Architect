import './ProjectProxy.css'

function ProjectProxy(props){
    return(
        <div className='project_proxy_container'>
            <h1>Name: {props.name}</h1>
            <h1>Description: {props.description}</h1>
            <button onClick={props.show}>Details</button>
        </div>
    );
}

export default ProjectProxy;