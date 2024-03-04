import PopupWithForm from "../PopupWithForm/PopupWithForm";
import './FormWithTable.css'

export default function FormWithTable({heads, children, amount, ...props}) {
  return <PopupWithForm {...props}>
      <table className='popup-list'>
        <thead className='popup-list__headers'>
          <tr className='popup-list__header-row'>
            {heads.map((head, id) => <th className={'popup-list__header'} scope='col' key={id}>{head}</th>)}
          </tr>
        </thead>
        <tbody>
          {children}
        </tbody>
        <tfoot>
          <tr>
            <th colSpan={2}>total: </th>
            <td>{amount}</td>
          </tr>
      </tfoot>
      </table>
  </PopupWithForm>
}