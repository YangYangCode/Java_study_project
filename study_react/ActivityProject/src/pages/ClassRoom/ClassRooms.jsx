import React, { useState } from "react";
import ClassRoom from "../../component/CR_Grid";
import { Link } from "react-router-dom";

function ClassRooms() {


    return (

        <div className="w-full">
            <br></br>
            <br></br>
            <br></br>
            <div >
                <h1 className="text-5xl text-center py-2 px-4 border-r border-gray-300">教室列表</h1>
            </div>
            <Link
                to="/addclassroom"
                className="bg-green-500 text-white px-4 py-2 mr-2 rounded-md hover:bg-green-600 hover:underline inline-block text-center"
            >
                新增教室
            </Link>
            <ul className="">
                <ClassRoom />
                <ClassRoom />
                <ClassRoom />
            </ul>
        </div>
    );
}

export default ClassRooms;