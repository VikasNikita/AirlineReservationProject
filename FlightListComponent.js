import React, { Component } from 'react';
import { connect } from 'react-redux';

class FlightFormComponent extends Component {
    render() {
        return (
            <>
              <h1>Flight List</h1>  
              <table className={"table"}>
                  <thead>
                        <tr>
                            <th>Flight Id</th>
                            <th>Flight Name</th>
                            <th>Source Location</th>
                            <th>Destination Location</th>
                            <th>Departure Date Time</th>
                            <th>Arrival Date Time</th>
                            <th>Economy Seat Price</th>
                            <th>Business Seat Price</th>
                            <th>Total Economy Seats</th>
                            <th>Total Business Seats</th>
                            <th>Available Economy Seats</th>
                            <th>Available Business Seats</th>
                            <th>Action</th>
                      </tr>
                  </thead>
                  <tbody>
                      {this.props.FlightList.map((flight,index)=> {
                          return(
                                <tr key={index}>
                                    <td>{index+1}</td>
                                    <td>{flight.flightName}</td>
                                    <td>{flight.sourceLocation}</td>
                                    <td>{flight.destinationLocation}</td>
                                    <td>{flight.departureDateTime}</td>
                                    <td>{flight.arrivalDateTime}</td>
                                    <td>{flight.economySeatPrice}</td>
                                    <td>{flight.businessSeatPrice}</td>
                                    <td>{flight.totalEconomySeats}</td>
                                    <td>{flight.totalBusinessSeats}</td>
                                    <td>{flight.availableEconomySeats}</td>
                                    <td>{flight.availableBusinessSeats}</td>
                                    <td>
                                     <button className="btn btn-danger" onClick={()=> {
                                         this.props.deleteFlightbyIndex(index)}}>Delete</button>
                                 </td>
                                </tr>
                          );
                      })}
                  </tbody>
              </table>
            </>
        );
    }
}
const mapStateStateToProps = (state) => {
    return {
        FlightList:  state.flightList,
    }
}
const mapDispatchToProps = (dispatch) => {
    return{
        deleteFlightbyIndex: (index) => dispatch ({type :"FLIGHT_DELETE",payload:index}),
    };
};
export default connect(mapStateStateToProps,mapDispatchToProps)(FlightFormComponent);