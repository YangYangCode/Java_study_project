import React from 'react';


const ClassRoom = () => {

    return (

        <div className="a-class-room">
            <div className="grid grid-cols-12 gap-4 p-4">
                <div className="col-span-2 bg-blue-300 p-4 text-center">
                    <br />
                    教室圖片<br />
                    教室名稱<br />
                    <br />
                </div>

                <div className="col-span-10 bg-green-300 p-4 ">
                    <button className="bg-red-400 mr-4 ">08:00-09:00</button>
                    <button className="bg-red-400 mr-4 ">09:00-10:00</button>
                    <button className="bg-red-400 mr-4 ">10:00-11:00</button>
                    <button className="bg-red-400 mr-4 ">11:00-12:00</button>
                    <button className="bg-red-400 mr-4 ">12:00-13:00</button>
                    <button className="bg-red-400 mr-4 ">13:00-14:00</button>
                    <button className="bg-red-400 mr-4 ">14:00-15:00</button>
                    <button className="bg-red-400 mr-4 ">15:00-16:00</button>
                    <button className="bg-red-400 mr-4 ">16:00-17:00</button>
                    <button className="bg-red-400 mr-4 ">17:00-18:00</button>
                    <button className="bg-red-400 mr-4 ">18:00-19:00</button>
                    <button className="bg-red-400 mr-4 ">19:00-20:00</button>
                </div>
            </div>
        </div>

    )
}
export default ClassRoom;