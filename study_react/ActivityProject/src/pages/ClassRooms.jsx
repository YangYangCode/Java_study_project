import React, { useState } from "react";
import ClassRoom from "../component/CR_Grid";

function CLassRooms() {


    return (

        <div className="w-full">
            <div >
                <h1 className="bg-blue-300">教室列表</h1>
            </div>

            <ul className="">
                <ClassRoom />
                <ClassRoom />
                <ClassRoom />
            </ul>
        </div>
    );
}

export default CLassRooms;