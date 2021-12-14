import React, { Component } from 'react';
import DepartmentService from './DepartmentService';

class ListDepartment extends Component
 {
    //  constructor(props) {
    //      super(props);
    //      this.state={
    //          DeptList:[],
    //      }
    //  }
    state ={
        DeptList:[],
    };
   
    componentDidMount (){
        DepartmentService.getDepartment().then((response) => {
            this.setState({DeptList:response.data});
        });
    }
    render() {
        return (
            <>
                <h2 className="text-center">Department List</h2>
                <div className="row">
                    <table className="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>DepartmentId</th>
                            <th>DepartmentName</th>
                            <th>DepartmentLocation</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.DeptList.map(
                            (department,index) => 
                            <tr key={index}>
                                <td>{department.deptId}</td>
                                <td>{department.deptName}</td>
                                <td>{department.deptLocation}</td>
                            </tr>)}
                        
                    </tbody>
                    </table>
                </div>
            </>
        );
    }
}

export default ListDepartment;