import logo from "./logo.svg";
import "./App.css";
// import Flight from './Flight';
// import FlightComponent from './FlightComponent';
import ListDepartment from "./ListDepartment";

function App() {
  return (
    <div className="container">
      {/* <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header> */}
      {/* <Flight/> */}
      {/* <FlightComponent/> */}
      <ListDepartment />
    </div>
  );
}

export default App;
