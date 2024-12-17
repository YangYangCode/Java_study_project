import React from 'react';

const CardItem = ({ activity }) => {  // 解構傳遞的 activity prop

    return (
        <li className="list-none">
            <div className="w-[175px] rounded-lg border border-gray-200 bg-white shadow-sm">
                <div className="p-4">

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

                    <button className="text-blue-600 hover:text-blue-800 text-sm font-semibold transition-colors">
                        information
                    </button>
                </div>
            </div>
        </li>
    );
};



export default CardItem;

