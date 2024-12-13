import React, { useState } from "react";
import CardItem from "../component/Fitn_CardItem";


function FitnessInstructors() {

    // Fitn List
    // -> 教練可點
    // -> 教練預約表


    return (

        <div className="w-full">
            <div >
                <h1 className="bg-blue-300">教練列表</h1>
            </div>

            <ul className="flex">
                <CardItem />
                <CardItem />
                <CardItem />
            </ul>
        </div>
    )
}

export default FitnessInstructors;