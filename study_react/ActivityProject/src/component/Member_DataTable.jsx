import React, { useEffect } from 'react';
import $ from "jquery";
import 'datatables.net-dt/css/dataTables.dataTables.min.css';
import "datatables.net";
import Button from '@mui/material/Button';
import { Link, useNavigate } from 'react-router-dom';


const MemberDataTable = ({ members }) => {

    // 初始化 DataTable
    useEffect(() => {
        if (members.length > 0) {
            const table = $("#example").DataTable();
            return () => {
                // 在組件卸載時銷毀 DataTable，避免多次初始化
                table.destroy();
            };
        }
    }, [members]);

    const tableCellClasses = "text-center py-2 px-4 border-r border-gray-300";

    return (
        <div className="min-h-screen flex justify-center">
            <div className="w-[90vw]">
                {/* <Link
                    to="/addmember"
                    className="bg-green-500 text-white px-4 py-2 mr-2 rounded-md hover:bg-green-600 hover:underline inline-block text-center"
                >
                    新增會員
                </Link> */}

                <table id="example" className="display border w-full table-auto">
                    <thead className='border-r border-gray-900'>
                        <tr>
                            <th style={{ textAlign: 'center', verticalAlign: 'middle' }}
                                className={tableCellClasses}>
                                會員名稱
                            </th>
                            <th style={{ textAlign: 'center', verticalAlign: 'middle' }}
                                className={tableCellClasses}>
                                會員調整
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        {members.map((item) => (
                            <tr key={item.id + 1}>
                                <td className={tableCellClasses}>{item.name}</td>
                                <td className="text-center py-2 px-4">
                                    <button
                                        className="bg-red-500 text-white px-4 py-2 rounded-md"
                                        onClick={() => console.log(item)}
                                    >
                                        刪除
                                    </button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};
export default MemberDataTable;



