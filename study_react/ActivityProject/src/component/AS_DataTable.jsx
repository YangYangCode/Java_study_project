import React, { useEffect } from 'react';
import $ from "jquery";
import 'datatables.net-dt/css/dataTables.dataTables.min.css';
import "datatables.net";


const ActivityScheduleDataTable = () => {

    // 資料陣列
    const data = [
        { id: 1, name: "John Doe", job: "工程師", age: 28 },
        { id: 2, name: "Jane Smith", job: "設計師", age: 32 },
        { id: 3, name: "Mike Johnson", job: "產品經理", age: 40 },
    ];

    // 初始化 DataTable
    useEffect(() => { $("#example").DataTable(); }, []);

    const tableCellClasses = "text-center py-2 px-4 border-r border-gray-300";

    return (
        <div className="min-h-screen flex justify-center">
            <div className="w-[90vw]">
                <table id="example" className="display border w-full table-auto">
                    <thead className='border-r border-gray-900'>
                        <tr>
                            <th style={{ textAlign: 'center', verticalAlign: 'middle' }}
                                className={tableCellClasses}>
                                姓名
                            </th>
                            <th style={{ textAlign: 'center', verticalAlign: 'middle' }}
                                className={tableCellClasses}>
                                職業
                            </th>
                            <th style={{ textAlign: 'center', verticalAlign: 'middle' }}
                                className={tableCellClasses}>
                                年齡
                            </th>
                            <th style={{ textAlign: 'center', verticalAlign: 'middle' }}
                                className="text-center py-2 px-4">
                                操作
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        {data.map((item) => (
                            <tr key={item.id}>
                                <td className={tableCellClasses}>{item.name}</td>
                                <td className={tableCellClasses}>{item.job}</td>
                                <td className={tableCellClasses}>{item.age}</td>
                                <td className="text-center py-2 px-4">
                                    <button className="bg-blue-500 text-white px-4 py-2 mr-2 rounded-md">修改</button>
                                    <button className="bg-red-500 text-white px-4 py-2 rounded-md">刪除</button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};
export default ActivityScheduleDataTable;



