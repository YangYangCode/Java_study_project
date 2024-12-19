import { Button } from '@mui/material';
import React from 'react';

const CardItem = ({ activity }) => {  // 解構傳遞的 activity prop

    return (
        <li className="list-none">
            <div className="w-[175px] rounded-lg border border-gray-200 bg-white shadow-sm">
                <div className="p-2">

                    {/* <p className="text-lg text-center font-semibold mb-2">
                        {activity.date}
                    </p>
                    <p className="text-lg text-center font-semibold mb-2">
                        {activity.weekday}
                    </p> */}

                    {/* Class Time */}
                    <p className="text-lg text-center font-semibold mb-2">
                        {activity.classTime}
                    </p>

                    {/* Class Type */}
                    <h2 className="text-xl text-center font-semibold mb-2">
                        {activity.classType.name}
                    </h2>

                    {/* Room */}
                    <p className="text-xl text-center font-semibold mb-2">
                        {activity.classRoom.name}
                    </p>

                    {/* Instructors */}
                    <h3 className="text-sm text-center font-semibold mb-2">
                        {Object.values(activity.fitnessInstructors).join(", ")}
                    </h3>

                    {/* Sign-up Count */}
                    <p className="text-sm text-center text-gray-600 mb-4">
                        報名人數: {Object.keys(activity.signedMembers).length}/{activity.maxSignNumber}
                    </p>

                    <Button className="w-full max-w-[150px] border border-gray-300 rounded-lg bg-white hover:bg-gray-100 transition-colors ring-2  focus:ring-blue-500">報名活動</Button>
                    <br/>
                    <Button className="w-full max-w-[150px] text-blue-600 hover:text-blue-800 text-sm font-semibold transition-colors border border-gray-300 ">
                        詳細資訊
                    </Button>
                </div>
            </div>
        </li>
    );
};



export default CardItem;

