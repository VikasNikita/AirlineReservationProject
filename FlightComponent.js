import React, { Component } from 'react';
import FlightFormComponent from "./FlightFormComponent";
import FlighListComponent from "./FlightListComponent";
class FlightComponent extends Component {
    render() {
        return (
            <>
              <h1>Flight Component</h1>  
              <br/>
              <div className="row">
                  <div className= "col-md-4">
                    {/* <FlightFormComponent/> */}
                  </div>
                  <div className= "col-md-8">
                    {/* <FlighListComponent/> */}
                  </div>
            </div>
            </>
        );
    }
}

export default FlightComponent;