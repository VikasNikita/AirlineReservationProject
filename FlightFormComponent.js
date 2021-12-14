import React, { Component } from 'react';
import {connect} from 'react-redux';

class FlightFormComponent extends Component 
{
    state = {
        flightName : "",
        sourceLocation : "",
        destinationLocation : "",
        departureDateTime : "",
        arrivalDateTime : "",
        economySeatPrice : 0,
        businessSeatPrice : 0,
        totalEconomySeats : 0,
        totalBusinessSeats : 0,
        availableEconomySeats : 0,
        availableBusinessSeats : 0,

    };

    onValueChangeHandler = (event) =>{
        const{name,value} =event.target;
        this.setState({[name]:value});
    };

    onSubmitFormHandler = (event) => {
        event.preventDefault();
        console.log(this.state);
        this.props.addFlight(this.state);
    }


    render() {
        return (
            <>
                <h1>Flight Form</h1>
        <br/>
        <form onSubmit={this.onSubmitFormHandler}>
        <div  className="mb-3">
        <label className="form-label" >Flight Name</label>
        <input className= "form-control"
         name="flightName" 
         value={this.state.flightName} 
         onChange={this.onValueChangeHandler}/>
        <br/>
        <br/>
        </div>
        <div  className="mb-3">
        <label className="form-label">Source Location</label>
        <input 
        className= "form-control"
         name="sourceLocation"
          value={this.state.sourceLocation} 
          onChange={this.onValueChangeHandler}/>
        <br/>
        <br/>
        </div>
        <div  className="mb-3">
        <label className="form-label">Destination Location</label>
        <input className= "form-control"
         name="destinationLocation" 
         value={this.state.destinationLocation} 
         onChange={this.onValueChangeHandler}/>
        <br/>
        <br/>
        </div>
        <div className="mb-3">
        <label className="form-label">DepartureDateTime</label>
        <input className= "form-control"
         type= "datetime-local" 
         name="departureDateTime" 
         value={this.state.departureDateTime} 
         onChange={this.onValueChangeHandler}/>
        <br/>
        <br/>
        </div>
        <div className="mb-3">
        <label className="form-label" >ArrivalDateTime</label>
        <input  
        className= "form-control"
        type= "datetime-local" 
        name="arrivalDateTime" 
        value={this.state.arrivalDateTime} 
        onChange={this.onValueChangeHandler}/>
        <br/>
        <br/>
        </div>
        <div className="mb-3">
        <label className="form-label" >EconomySeatPrice</label>
        <input 
        className= "form-control" 
        name="economySeatPrice" 
        value={this.state.economySeatPrice} 
        onChange={this.onValueChangeHandler}/>
        <br/>
        <br/>
        </div>
        <div className="mb-3">
        <label className="form-label" placeholder="Enter BusinessSeatPrice">BusinessSeatPrice</label>
        <input 
        className= "form-control"  
        name="businessSeatPrice" 
        value={this.state.businessSeatPrice} 
        onChange={this.onValueChangeHandler}/>
        <br/>
        </div>
        <div className="mb-3">
        <label className="form-label" >TotalEconomySeats</label>
        <input 
        className="form-control" 
        name="totalEconomySeats" 
        value={this.state.totalEconomySeats} 
        onChange={this.onValueChangeHandler}/>
        <br/>
        <br/>
        </div>
        <div className="mb-3">
        <lable className="form-label" >TotalBusinessSeats</lable>
        <input 
        className= "form-control" 
        name="totalBusinessSeats" 
        value={this.state.totalBusinessSeats} 
        onChange={this.onValueChangeHandler}/>
        <br/>
        <br/>
        </div>
        <div className="mb-3">
        <label className="form-label" >AvailableEconomySeats</label>
        <input 
        className= "form-control" 
        name="availableEconomySeats" 
        value={this.state.availableEconomySeats} 
        onChange={this.onValueChangeHandler}/>
        <br/>
        <br/>
        </div>
        <div className="mb-3">
        <label className="form-label" className="Available Business Seat">Available BusinessSeat</label>
        <input 
        className= "form-control" 
        name="availableBusinessSeats"  
        value={this.state.availableBusinessSeats} 
        onChange={this.onValueChangeHandler}/>
        <br/>
        </div>
        <button type="submit" className="btn btn-success">Submit</button>
    </form>
        
            </>
        );
    }
}

const onMapStateToProps = () => {
    return {};
}

const onMapDispatchToProps = (dispatch) => {
    return {
        addFlight: (payload) => dispatch({type : "FLIGHT_ADD",payload:payload}),
    };
}

export default connect(onMapStateToProps,onMapDispatchToProps)(FlightFormComponent)