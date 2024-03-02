import { useCallback, useEffect, useRef, useState } from "react";

export default function useForm(formName) {
  const
    [inputs, setInputs] = useState({}),
    base = useRef(undefined),

    handleChange = useCallback((e) => {
      setInputs((input) => {
        const
          target = e.target,
          aName = target.name;

        input[aName].hasMssg = true
        input[aName].value = target.value;
        input[aName].validationMessage = target.validationMessage

        return structuredClone(input)
      })
    }, []),

    resetForm = useCallback(() => {
      setInputs(structuredClone(base.current))
    }, []),

    getValues = () => Object
      .entries(inputs)
      .reduce((obj, [key, { value }]) => Object.assign(obj, {[key]: value}), {});

  useEffect(() => {
    const formInputs = Object.fromEntries(
      Array
        .from(document.forms[formName].elements)
        .filter(({ nodeName }) => nodeName === 'INPUT' || nodeName === 'TEXTAREA' || nodeName === 'SELECT')
        .map(({ name, value }) => [name, {value, hasMssg: false}])
    )

    setInputs(formInputs)
    base.current = structuredClone(formInputs)
  }, [formName])

  return {
    inputs,
    getValues,
    handleChange,
    resetForm,
  }
}